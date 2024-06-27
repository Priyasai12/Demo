const express = require('express');
const jwt = require('jsonwebtoken');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
const PORT = 5000;
const SECRET_KEY = 'your_secret_key';

app.use(cors());
app.use(bodyParser.json());

app.post('/login', (req, res) => {
    const { username, password } = req.body;
    if (username === 'Priya' && password === 'Priya@123') {
        const token = jwt.sign({ username }, SECRET_KEY, { expiresIn: '1h' });
        return res.json({ token });
    }
    res.status(401).json({ message: 'Invalid credentials' });
});

app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});
