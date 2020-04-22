#!/usr/bin/groovy
def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
   def username = config.user
   def hostname = config.hostname
   def email=config.email

    
    stage(os details){
        sshagent(['ubuntucreds']) {
    sh 'ssh -o StrictHostKeyChecking=no -l ${username} ${hostname} cat /etc/*-release '
}
    }
    stage (notification){
        emailext( 
     attachLog: true,
     body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
     recipientProviders: [developers(), requestor()],
     subject: "OS Details",
     to: ${email} )
    }
}
