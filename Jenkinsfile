node {
       stage('get tha Git') {
       git 'https://github.com/Revature-1704-Java/p2-JAMMS.git'
            echo 'Whaddap binchzzz??'
    }
        
        stage('Build') {
            
               sh 'make' 
                archiveArtifacts artifacts: 'ebook-store', fingerprint: true 
            
        }
        stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
           
                sh 'make publish'
            
        }
}
