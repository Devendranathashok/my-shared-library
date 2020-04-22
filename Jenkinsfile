node{
     stage('osdetails'){
        sshagent(['remotehostcreds']) {
    sh 'ssh -o StrictHostKeyChecking=no  $username@$hostname cat /etc/os-release >> os_details.txt '
}
    }
    // stage('notification'){
    //     always {
    //         archiveArtifacts artifacts: 'os_details.txt', onlyIfSuccessful: true
    // env.ForEmailPlugin = env.WORKSPACE
    // emailext attachLog: true, attachmentsPattern: 'os_details.txt',
    //  body: 'os details',
    //  subject: "OSDetails",
	//  to: '$email'
    //   }
    // }
    stage('notification'){
   e emailext(
    body: """
	SUCCESSFUL: Job \'${env.JOB_NAME} [${env.BUILD_NUMBER}]\':  
	Check console output at "${env.JOB_NAME} [${env.BUILD_NUMBER}]"
	""", recipientProviders: [developers()], subject: '"SUCCESSFUL: Job \'${env.JOB_NAME} [${env.BUILD_NUMBER}]\'"',
	to: 'reachashok9538053428@gmail.com')
    }
}

