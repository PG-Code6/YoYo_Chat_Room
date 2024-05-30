import axios from 'axios'

const request = axios.create({
    baseURL: 'http://localhost:9091/',
    timeout: 30000    //前后端响应超时时间
})

export default request
