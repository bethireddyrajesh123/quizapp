
pipeline {
    agent any

    triggers {
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo "GitHub push event received. Job triggered successfully. and we are now testing"
            }
        }
    }
}
