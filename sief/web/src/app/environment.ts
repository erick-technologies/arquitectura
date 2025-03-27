const apiConfig = {
  demo_mode: true
}

export const environment = {
  production: false
  ,apiConfig
  ,offline: true
  ,api: {
    protocol:"http://",
    baseUrl: 'localhost:8080',
    authPath: "/login",
    auth: "Authorization",
    requestTime: 3000000
  }
};

