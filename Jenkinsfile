pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               sh 'make' 
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
                echo 'This Werx'
            }
        }
        stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            steps {
                sh 'make publish'
            }
        }
    }
}
        
