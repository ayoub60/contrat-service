pipeline {
    agent any
    tools {
        maven "MAVEN3"
        jdk "OracleJdk17"
    }

    stages {
        stage('Build'){
            steps{
                sh 'mvn -s settings.xml clean package'
            }
            post {
                success {
                    echo 'Build Succefuly ...'
                }
            }
        }
    }
}