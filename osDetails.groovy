node{
     stage('osdetails'){
        sshagent(['remotehostcreds']) {
    sh 'ssh -o StrictHostKeyChecking=no  $username@$hostname cat /etc/os-release '
}
    }
    stage('notification'){
    emailext( 
     attachLog: true,
     body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
     recipientProviders: [developers(), requestor()],
     subject: "OS Details",
     to: '$email' )
    }
}