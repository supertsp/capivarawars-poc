const express = require('express')
const app = express()

const config = require('./config/config')
const router = require('./routes/router')

app.use('/', router)

app.listen(config.port, () => {
    console.log(`Server listening in port: ${config.port}`)
})