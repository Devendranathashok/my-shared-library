node{
     stage('osdetails'){
        sshagent(['remotehostcreds']) {
    sh 'ssh -o StrictHostKeyChecking=no  $username@$hostname cat /etc/os-release  '
    sh 'ssh -o StrictHostKeyChecking=no  $username@$hostname cat /etc/os-release >> os_details.txt '
}
    }
    
    stage('notification') { 
    emailext (
    attachLog: true,
    //attachmentsPattern: 'os_details.txt', 
	body: """
	STARTED: Job \'${env.JOB_NAME} [${env.BUILD_NUMBER}]\':
	Check console output at "${env.JOB_NAME} [${env.BUILD_NUMBER}]"
	""", subject: 'subject: "os details",', 
	to: '$email' )}
// stage('notification'){
//     stage('notification'){
//     emailext(
//     body: """
// 	SUCCESSFUL: Job \'${env.JOB_NAME} [${env.BUILD_NUMBER}]\':  
// 	Check console output at "${env.JOB_NAME} [${env.BUILD_NUMBER}]"
// 	""", recipientProviders: [developers()], subject: '"SUCCESSFUL: Job \'${env.JOB_NAME} [${env.BUILD_NUMBER}]\'"',
// 	to: 'reachashok9538053428@gmail.com')
//     }
// }
}
