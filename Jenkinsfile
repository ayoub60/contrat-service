pipeline {
    agent any
    tools {
        maven "MAVEN3"
        jdk "OracleJdk17"
    }

    stages {
        stage('Build'){
            steps{
                sh 'mvn clean package -U'
            }
            post {
                success {
                    echo 'Build Succefuly ...'
                }
            }
        }
    }
}