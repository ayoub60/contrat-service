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
        stage('Read POM') {
            steps {
                script {
                    version = sh script: 'mvn help:evaluate -Dexpression=project.version -q -DforceStdout', returnStdout: true

                    echo "Project version: ${version}"
                }
            }
        }
        stage('Build POM parent'){
            steps{
                sh 'mvn -s settings.xml clean install'
            }

            post {
                success {
                    echo 'Build Succefuly ...'
                }
            }
        }
        stage('Upload artifact POM parent') {
            steps{
                nexusArtifactUploader(
                        nexusVersion: 'nexus3',
                        protocol: 'http',
                        nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
                        groupId: 'ma.sirh.tassyircom',
                        version: "${version}",
                        repository: "${SNAP_REPO}",
                        credentialsId: "${NEXUS_LOGIN}",
                        artifacts: [
                                [artifactId: 'contrat-service',
                                 file: 'pom.xml',
                                 type: 'pom']
                        ]
                )
//                }

            }
        }

        stage('Build All modules'){
            steps{
                dir('contrat-service-dto') {
                    nexusArtifactUploader(
                            nexusVersion: 'nexus3',
                            protocol: 'http',
                            nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
                            groupId: 'ma.sirh.tassyircom',
                            version: "${version}",
                            repository: "${SNAP_REPO}",
                            credentialsId: "${NEXUS_LOGIN}",
                            artifacts: [
                                    [artifactId: 'contrat-service-dto',
                                     file: 'target/contrat-service-dto-1.0.0-SNAPSHOT.jar',
                                     type: 'jar']
                            ]
                    )
                }

                dir('contrat-domain') {
                    nexusArtifactUploader(
                            nexusVersion: 'nexus3',
                            protocol: 'http',
                            nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
                            groupId: 'ma.sirh.tassyircom',
                            version: "${version}",
                            repository: "${SNAP_REPO}",
                            credentialsId: "${NEXUS_LOGIN}",
                            artifacts: [
                                    [artifactId: 'contrat-domain',
                                     file: 'pom.xml',
                                     type: 'pom']
                            ]
                    )
                    dir('contrat-application-service') {
                        nexusArtifactUploader(
                                nexusVersion: 'nexus3',
                                protocol: 'http',
                                nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
                                groupId: 'ma.sirh.tassyircom',
                                version: "${version}",
                                repository: "${SNAP_REPO}",
                                credentialsId: "${NEXUS_LOGIN}",
                                artifacts: [
                                        [artifactId: 'contrat-application-service',
                                         file: 'target/contrat-application-service-1.0.0-SNAPSHOT.jar',
                                         type: 'jar']
                                ]
                        )
                    }

                    dir('contrat-domain-core') {
                        nexusArtifactUploader(
                                nexusVersion: 'nexus3',
                                protocol: 'http',
                                nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
                                groupId: 'ma.sirh.tassyircom',
                                version: "${version}",
                                repository: "${SNAP_REPO}",
                                credentialsId: "${NEXUS_LOGIN}",
                                artifacts: [
                                        [artifactId: 'contrat-domain-core',
                                         file: 'target/contrat-domain-core-1.0.0-SNAPSHOT.jar',
                                         type: 'jar']
                                ]
                        )
                    }

                }

//
                dir('contrat-messaging') {
                    nexusArtifactUploader(
                            nexusVersion: 'nexus3',
                            protocol: 'http',
                            nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
                            groupId: 'ma.sirh.tassyircom',
                            version: "${version}",
                            repository: "${SNAP_REPO}",
                            credentialsId: "${NEXUS_LOGIN}",
                            artifacts: [
                                    [artifactId: 'contrat-messaging',
                                     file: 'target/contrat-messaging-1.0.0-SNAPSHOT.jar',
                                     type: 'jar']
                            ]
                    )
                }

            }

            post {
                success {
                    echo 'Build Succefuly ...'
                }
            }
        }
    }
}