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
def call(String awsaccount_id,String region, String ECR_REPO_NAME){
    sh """
    aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${awsaccount_id}.dkr.ecr.us-east-1.amazonaws.com
    docker push ${awsaccount_id}.dkr.ecr.${region}.amazonaws.com/${ECR_REPO_NAME}:latest
    """
} 
// docker push public.ecr.aws/r1f4w1h4/springboot-chat-app:latest
//     docker push ${awsaccount_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
