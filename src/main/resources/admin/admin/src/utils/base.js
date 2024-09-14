const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot4w247725/",
            name: "springboot4w247725",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot4w247725/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "学生服务平台"
        } 
    }
}
export default base
