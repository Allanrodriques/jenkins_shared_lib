// def call(String project,String ImageTag, String hubUser){
//     withCredentials([usernamePassword(
//                                 credentialsId: 'docker', 
//                                 passwordVariable: 'PASS', 
//                                 usernameVariable: 'USER'
//                     )]) {
//     sh "docker login -u ${USER} -p ${PASS}"
//     sh "docker image push ${hubUser}/${project}:${ImageTag}"
//     sh "docker image push ${hubUser}/${project}:latest"
// }
// }
def call(String awsaccount_id,String region, String ecr_repoName){
    sh "aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 473871105018.dkr.ecr.us-east-2.amazonaws.com"
    sh "docker push ${ecr_repoName}:latest ${awsaccount_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest"
}  

