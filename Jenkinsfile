pipeline {
    agent any
 
    tools {
        jdk 'JDK-17'
        maven 'Maven-3.9.6'
    }
 
    stages {
        stage('Check Java') {
            steps {
                sh 'java -version'
            }
        }
 
        stage('Check Maven') {
            steps {
                sh 'mvn -version'
            }
        }
    }
}
