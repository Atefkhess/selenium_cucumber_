pipeline {
    agent any
    
    stages {
        
        
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/Atefkhess/selenium_cucumber_'
         
                sh 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        
        stage('Rapport de test') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber-report.json",
                    jsonReportDirectory:'target'
            }
        }
    }
}
