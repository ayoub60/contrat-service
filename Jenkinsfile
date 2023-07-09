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
//        stage('Upload artifact POM parent') {
//            steps{
//                nexusArtifactUploader(
//                        nexusVersion: 'nexus3',
//                        protocol: 'http',
//                        nexusUrl: "${NEXUSIP}:${NEXUSPORT}",
//                        groupId: 'ma.sirh.tassyircom',
//                        version: "${version}",
//                        repository: "${SNAP_REPO}",
//                        credentialsId: "${NEXUS_LOGIN}",
//                        artifacts: [
//                                [artifactId: 'contrat-service',
//                                 file: 'pom.xml',
//                                 type: 'pom']
//                        ]
//                )
////                }
//
//            }
//        }

        stage('Build All modules'){
            steps{
                dir('contrat-service-dto') {
                    sh 'mvn -s ../settings.xml clean install'
                    sh 'ls target/'
                   //archiveArtifacts artifacts: '**/target/*.jar'
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
                                     file: 'pom.xml',
                                     type: 'pom']
                            ]
                    )
                }

//                dir('contrat-domain') {
//                    sh 'mvn -s ../settings.xml clean install'
//                }


//                dir('contrat-repository') {
//                    sh 'mvn -s ../settings.xml clean install'
//                }
//
                dir('contrat-messaging') {
                    sh 'mvn -s ../settings.xml clean install'

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
//
//                dir('contrat-rest') {
//                    sh 'mvn -s ../settings.xml clean install'
//                }
//
//                dir('contrat-container') {
//                    sh 'mvn -s ../settings.xml clean install'
//                }

            }

            post {
                success {
                    echo 'Build Succefuly ...'
                }
            }
        }
    }
}