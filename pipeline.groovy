timestamps{
    node('master'){
       
        stage('Checkout'){
            sh "rm -Rf juice-shop" 
            sh 'git clone https://github.com/bkimminich/juice-shop.git'
        }
        stage('Dependency check'){
            sh "/opt/dependency-check/bin/dependency-check.sh --project \"juice shop\" -s ."
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: '', reportFiles: 'dependency-check-report.html', reportName: 'HTML Report', reportTitles: ''])
            
        }
        stage('Zap Scan'){

        }
    }
}
