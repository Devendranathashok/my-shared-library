node{
     stage('osdetails'){
        sshagent(['remotehostcreds']) {
    sh 'ssh -o StrictHostKeyChecking=no  $username@$hostname cat /etc/os-release >> os_details.txt '
}
    }
    stage('notification'){
        always {
            archiveArtifacts artifacts: 'os_details.txt', onlyIfSuccessful: true
    env.ForEmailPlugin = env.WORKSPACE
    emailext attachLog: true, attachmentsPattern: 'os_details.txt',
     body: 'os details',
     subject: "OSDetails",
	 to: '$email'
      }
    }
}
