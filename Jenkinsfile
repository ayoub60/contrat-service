pipeline {
    agent any
    tools {
        maven "MAVEN3"
        jdk "OracleJdk17"
    }
    environment {
        SNAP_REPO = 'tassyircom-snapshot'
        NEXUS_USER= 'admin'
        NEXUS_PASS = 'admin'
        RELEASE_REPO= 'tassyircom-release'
        CENTRAL_REPO= 'tassyircom-maven-central'
        NEXUSIP= '172.31.87.101'
        NEXUSPORT = '8081'
        NEXUS_GRP_REPO = "tassyircom-maven-group"
        NEXUS_LOGIN= 'nexuslogin'
        version = ""
    }
    stages {

        stage('Build POM parent'){
            steps{
                script {
                    version = sh script: 'mvn help:evaluate -Dexpression=project.version -q -DforceStdout', returnStdout: true
                    echo "Project version: ${version}"
                }
                sh 'mvn -s settings.xml clean package'
            }

            post {
                success {
                    echo 'Build Succefuly ...'
                }
            }
        }

        stage('Push to nexus'){
            steps {
                dir("contrat-service-dto") {
                    script {
                        // Build and package the submodule using Maven
                        // Upload the JAR and POM artifacts to Nexus
                        def mydir = sh "ls"
                        echo "liste dir ${mydir}"
                        sh "mvn deploy:deploy-file " +
                                " -Durl=${NEXUSIP}:${NEXUSPORT} " +
                                "-DrepositoryId=nexus " +
                                "-Dfile=target/contrat-service-dto-1.0.0-SNAPSHOT.jar" +
                                " -DgroupId=ma.sirh.tassyircom " +
                                " -DartifactId=contrat-service-dto" +
                                " -Dversion=1.0.0-SNAPSHOT " +
                                " -Dpackaging=jar " +
                                " -DgeneratePom=true " +
                                " -DpomFile=pom.xml " +
                                " -DuniqueVersion=false " +
                                " -DretryFailedDeploymentCount=3 " +
                                " -DskipTests " +
                                "-DnexusUsername=${NEXUS_USER} " +
                                "-DnexusPassword=${NEXUS_PASS}"
                                " -DupdateReleaseInfo=true " +
                                " -Dmaven.deploy.skip=false " +
                                " -Dmaven.test.skip=true " +
                                " -Dmaven.install.skip=true " +
                                " -Dmaven.compile.skip=true " +
                                " -s ../settings.xml " +
                                " -X -e " +
                                " -B"
                    }
                }
            }
        }
//        stage('Push to nexus'){
//            steps {
//                script {
//
//                    def pomContent = readFile('pom.xml')
//                    def modules = pomContent.readLines().findAll { it =~ /<module>/ }
//                            .collect { it.replace('<module>', '').replace('</module>', '').trim() }
//                    for (def module in modules) {
//                        echo "Module ...${module}"
//                        dir(module) {
//                            // Determine the packaging type of the module
//                            def packaging = sh(
//                                    script: "mvn help:evaluate -Dexpression=project.packaging -q -DforceStdout",
//                                    returnStdout: true
//                            ).trim()
//                            if (packaging == 'pom') {
//                                def pomContent1 = readFile('pom.xml')
//                                def submodules = pomContent1.readLines().findAll { it =~ /<module>/ }
//                                        .collect { it.replace('<module>', '').replace('</module>', '').trim() }
//                                echo 'Project pom';
//                                for (def submodule in submodules) {
//                                    echo "Project ${submodule}";
//                                    dir(submodule) {
//                                        // Build and package the submodule using Maven
//                                        // Upload the JAR and POM artifacts to Nexus
//                                        sh "mvn deploy:deploy-file " +
//                                                "-Durl=${NEXUSIP}:${NEXUSPORT} " +
//                                                "-DrepositoryId=nexus " +
//                                                "-Dfile=target/${submodule}-${version}.jar " +
//                                                "-DgroupId=ma.sirh.tassyircom " +
//                                                "-DartifactId=${submodule} " +
//                                                "-Dversion=1.0.0-SNAPSHOT " +
//                                                "-Dpackaging=jar " +
//                                                "-DgeneratePom=true " +
//                                                "-DpomFile=pom.xml " +
//                                                "-DuniqueVersion=false " +
//                                                "-DretryFailedDeploymentCount=3 " +
//                                                "-DskipTests " +
//                                                "-DupdateReleaseInfo=true " +
//                                                "-Dmaven.deploy.skip=false " +
//                                                "-Dmaven.test.skip=true " +
//                                                "-Dmaven.install.skip=true " +
//                                                "-Dmaven.compile.skip=true " +
//                                                "-s ../../settings.xml " +
//                                                "-X -e " +
//                                                "-B"
//                                    }
//                                }
//                            } else {
//                                echo 'Project jar'
//                                dir(module) {
//                                    // Build and package the submodule using Maven
//                                    // Upload the JAR and POM artifacts to Nexus
//                                    sh "ls /target"
//                                    sh "mvn deploy:deploy-file " +
//                                            "-Durl=${NEXUSIP}:${NEXUSPORT} " +
//                                            "-DrepositoryId=nexus " +
//                                            "-Dfile=target/${module}-${version}.jar " +
//                                            "-DgroupId=ma.sirh.tassyircom " +
//                                            "-DartifactId=${module} " +
//                                            "-Dversion=1.0.0-SNAPSHOT " +
//                                            "-Dpackaging=jar " +
//                                            "-DgeneratePom=true " +
//                                            "-DpomFile=pom.xml " +
//                                            "-DuniqueVersion=false " +
//                                            "-DretryFailedDeploymentCount=3 " +
//                                            "-DskipTests " +
//                                            "-DupdateReleaseInfo=true " +
//                                            "-Dmaven.deploy.skip=false " +
//                                            "-Dmaven.test.skip=true " +
//                                            "-Dmaven.install.skip=true " +
//                                            "-Dmaven.compile.skip=true " +
//                                            "-s ../settings.xml " +
//                                            "-X -e " +
//                                            "-B"
//                                }
//                            }
//                        }
//                    }
//                }
//            }
////            steps{
////                nexusArtifactUploader(
////                        nexusVersion: 'nexus3',
////                        protocol: 'http',
////                        nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
////                        groupId: 'ma.sirh.tassyircom',
////                        version: "${version}",
////                        repository: "${SNAP_REPO}",
////                        credentialsId: "${NEXUS_LOGIN}",
////                        artifacts: [
////                                [artifactId: 'contrat-service',
////                                 file: 'pom.xml',
////                                 type: 'pom']
////                        ]
////                )
////                def modules = ['contrat-service-dto', 'module2']
////                dir('contrat-service-dto') {
////                    nexusArtifactUploader(
////                            nexusVersion: 'nexus3',
////                            protocol: 'http',
////                            nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
////                            groupId: 'ma.sirh.tassyircom',
////                            version: "${version}",
////                            repository: "${SNAP_REPO}",
////                            credentialsId: "${NEXUS_LOGIN}",
////                            artifacts: [
////                                    [artifactId: 'contrat-service-dto',
////                                     file: 'target/contrat-service-dto-1.0.0-SNAPSHOT.jar',
////                                     type: 'jar']
////                            ]
////                    )
////                }
////
////                dir('contrat-domain') {
////                    nexusArtifactUploader(
////                            nexusVersion: 'nexus3',
////                            protocol: 'http',
////                            nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
////                            groupId: 'ma.sirh.tassyircom',
////                            version: "${version}",
////                            repository: "${SNAP_REPO}",
////                            credentialsId: "${NEXUS_LOGIN}",
////                            artifacts: [
////                                    [artifactId: 'contrat-domain',
////                                     file: 'pom.xml',
////                                     type: 'pom']
////                            ]
////                    )
////                    dir('contrat-application-service') {
////                        nexusArtifactUploader(
////                                nexusVersion: 'nexus3',
////                                protocol: 'http',
////                                nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
////                                groupId: 'ma.sirh.tassyircom',
////                                version: "${version}",
////                                repository: "${SNAP_REPO}",
////                                credentialsId: "${NEXUS_LOGIN}",
////                                artifacts: [
////                                        [artifactId: 'contrat-application-service',
////                                         file: 'target/contrat-application-service-1.0.0-SNAPSHOT.jar',
////                                         type: 'jar']
////                                ]
////                        )
////                    }
////
////                    dir('contrat-domain-core') {
////                        nexusArtifactUploader(
////                                nexusVersion: 'nexus3',
////                                protocol: 'http',
////                                nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
////                                groupId: 'ma.sirh.tassyircom',
////                                version: "${version}",
////                                repository: "${SNAP_REPO}",
////                                credentialsId: "${NEXUS_LOGIN}",
////                                artifacts: [
////                                        [artifactId: 'contrat-domain-core',
////                                         file: 'target/contrat-domain-core-1.0.0-SNAPSHOT.jar',
////                                         type: 'jar']
////                                ]
////                        )
////                    }
////
////                }
////                dir('contrat-messaging') {
////                    nexusArtifactUploader(
////                            nexusVersion: 'nexus3',
////                            protocol: 'http',
////                            nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
////                            groupId: 'ma.sirh.tassyircom',
////                            version: "${version}",
////                            repository: "${SNAP_REPO}",
////                            credentialsId: "${NEXUS_LOGIN}",
////                            artifacts: [
////                                    [artifactId: 'contrat-messaging',
////                                     file: 'target/contrat-messaging-1.0.0-SNAPSHOT.jar',
////                                     type: 'jar']
////                            ]
////                    )
////                }
////
////                dir('contrat-rest') {
////                    nexusArtifactUploader(
////                            nexusVersion: 'nexus3',
////                            protocol: 'http',
////                            nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
////                            groupId: 'ma.sirh.tassyircom',
////                            version: "${version}",
////                            repository: "${SNAP_REPO}",
////                            credentialsId: "${NEXUS_LOGIN}",
////                            artifacts: [
////                                    [artifactId: 'contrat-rest',
////                                     file: 'target/contrat-rest-1.0.0-SNAPSHOT.jar',
////                                     type: 'jar']
////                            ]
////                    )
////                }
////
////                dir('contrat-container') {
////                    nexusArtifactUploader(
////                            nexusVersion: 'nexus3',
////                            protocol: 'http',
////                            nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
////                            groupId: 'ma.sirh.tassyircom',
////                            version: "${version}",
////                            repository: "${SNAP_REPO}",
////                            credentialsId: "${NEXUS_LOGIN}",
////                            artifacts: [
////                                    [artifactId: 'contrat-container',
////                                     file: 'target/contrat-container-1.0.0-SNAPSHOT.jar',
////                                     type: 'jar']
////                            ]
////                    )
////                }
////
////            }
//
//            post {
//                success {
//                    echo 'Push to nexus avec succéss ...'
//                }
//            }
//        }
    }
}