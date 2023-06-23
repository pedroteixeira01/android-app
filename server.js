const jsonServer = require('json-server');
const auth = require('json-server-auth');
const db = require('./db.json');

const server = jsonServer.create();
const router = jsonServer.router(db);
const middlewares = jsonServer.defaults();

const authenticateUser = (req, res, next) => {
  const { username, password } = req.body;

  const user = db.usuarios.find(
    (user) => user.nome === username && user.senha === password
  );

  if (user) {
    return res.status(201).json({ token: user.token });
  }

  return res.status(401).json({ error: 'Usuário não autenticado' });
};

server.db = router.db;
server.use(middlewares);
server.use(jsonServer.bodyParser);

// Rota de autenticação
server.post('/auth', authenticateUser);

// Segurança básica
server.use(auth);
server.use(router);

server.listen(3000, () => {
  console.log('JSON Server with Auth is running on port 3000');
});
