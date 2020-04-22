node{
     stage('osdetails'){
        sshagent(['remotehostcreds']) {
    sh 'ssh -o StrictHostKeyChecking=no  $username@$hostname cat /etc/os-release >> os_details.txt '
}
    }
    stage('notification'){
    emailext attachLog: true, attachmentsPattern: 'os_details.txt',
     body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
     subject: "OSDetails",
	 to: '$email'
    }
}
