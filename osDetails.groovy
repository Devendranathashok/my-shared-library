node{
     stage('osdetails'){
        sshagent(['remotehostcreds']) {
    sh 'ssh -o StrictHostKeyChecking=no  $username@$hostname cat /etc/os-release >> os_details.txt '
}
    }
    stage('notification'){
    emailext attachmentsPattern: '**/os_details.txt', body: 'osdetails', subject: 'OsDetails', to: '$email', attachLog: true
    }
}