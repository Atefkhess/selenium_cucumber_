pipeline {
    agent any
     tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }
    
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
