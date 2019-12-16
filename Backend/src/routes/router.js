const express = require('express')
const router = express.Router()

router.get('/match', async (req, res) => {
    //MATCH GET
})

router.post('/match', async (req, res) => {
    //MATCH POST
})
router.put('/match', async (req, res) => {
    //MATCH PUT
})
router.delete('/match', async (req, res) => {
    //MATCH DELETE
})

router.get('/game-status', async (req, res) => {
    //GAME STATUS GET
})

router.post('/game-status', async (req, res) => {
    //GAME STATUS POST
})

router.put('/game-status', async (req, res) => {
    //GAME STATUS PUT
})

router.delete('/game-status', async (req, res) => {
    //GAME STATUS DELETE
})

router.get('/championship', async (req, res) => {
    //CHAMPIONSHIP GET
})

router.post('/championship', async (req, res) => {
    //CHAMPIONSHIP POST
})

router.put('/championship', async (req, res) => {
    //CHAMPIONSHIP PUT
})

router.delete('/championship', async (req, res) => {
    //CHAMPIONSHIP DELETE
})

router.get('/check', async (req, res) => {
    res.status(200).json("check");
})

module.exports = router;