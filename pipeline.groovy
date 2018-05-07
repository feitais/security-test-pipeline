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
            //sh 'mkdir -p wrk && mv oi-digital.conf wrk/'
            //sh 'sudo docker run --rm -v $WORKSPACE_OUT/wrk/:/zap/wrk/:rw -t owasp/zap2docker-weekly zap-baseline.py -t $scan_site -c oi-digital.conf -r JENKINS_ZAP_VULNERABILITY_REPORT_${BUILD_ID}.html -m $tempo_max_scan -d'
        }
    }
}
