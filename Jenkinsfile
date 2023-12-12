pipeline {
    agent any

    tools {
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/Atefkhess/selenium_cucumber_'
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
    
    post {
        always {
            script {
                def buildStatus = currentBuild.result ?: 'UNKNOWN'
                emailext subject: 'Jenkins Build Notification',
                          body: "Hello,\n\nThe Jenkins build for NopCommerce has completed.\n\nBuild Status: ${buildStatus}\nBuild Number: ${BUILD_NUMBER}\nBuild URL: ${BUILD_URL}\n\nYou can view the console output and details on the Jenkins dashboard.\n\nThank you,\nAtef Khessib",
                          to: 'khessibatef@gmail.com',
                          from: 'jenkins@gmail.com'   
            }
        }
    }
}
