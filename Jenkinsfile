node{
     stage('osdetails'){
        sshagent(['remotehostcreds']) {
    sh 'ssh -o StrictHostKeyChecking=no  $username@$hostname cat /etc/os-release >> os_details.txt '
}
    }
    stage('notification'){
    env.ForEmailPlugin = env.WORKSPACE
    emailext attachLog: true, attachmentsPattern: 'os_details.txt',
     body: '${FILE, path="os_details.txt"}',
     subject: "OSDetails",
     mimeType: 'text/html',
	 to: '$email'
    }
}
