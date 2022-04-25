# Curso de Webpack

## Comandos:
    **Instalar o node na aplicação:**
        $npm install

    **Instalar o webpack na aplicação**
        $npm install webpack@version
        $npm install --save-dev webpack-cli

    **Instalando plugins**
        $npm install html-webpack-plugin@version --save-dev
        $npm install copy-webpack-plugin@version --save-dev
        $npm install css-loader@version --save-dev
        $npm install style-loader@version --save-dev
        $npm install mini-css-extract-plugin@version --save-dev
        $npm install css-minimizer-webpack-plugin@version --save-dev

    **Intalando bootstrap na aplicação**
        $npm install bootstrap@version --save
    
    **Instalando dev server**
        $npm install webpack-dev-server@version --save-dev

    **Rodar scripts com node**
        $npm run *nome do script no arquivo package.json*

    Criar na raiz do projeto o arquivo webpack.config.js
    Criar um script no package.json para fazer o build da aplicação

## O que eu to entendo até então 
    O webpack serve pra centraliza todos arquivos js num arquivo chamado bundle.js e ao mesmo tempo faz um monte de otimização, deixando a aplicação mais performática;
    O webpack foi feito pra fazer essas otimizações só com arquivos js, por isso que se não for configurado, o css dá página não carrega;
    O **--mode** no package.json muda a forma que vai ser gerado, pra quem ele vai ser gerado(dev ou produção);
    A minha aplicação pode querer deixar o bundle salvo em cache, e se eu atulizar a aplicação sem mudar o nome do arquivo bundle, o navegador não sabe que teve versão nova. Ele do cache e pronto. Pra evitar isso se passa um hash no arquivo bundle. Quem faz isso é a propriedade **hash: true** nas configurações do plugin HtmlWebpackPlugin;
    Quando o bootstrap é instalado pelo npm, ele vai ser tratado como um módulo do node, podendo ser importado no app.js, atualizado etc;
    Porém... no caso de bibliotecas css, elas precisam ser configuradas pelo webpack para serem tratadas da maneira certa;
    A maneira de importar essas bibliotecas, é através do plugin css loader do webpack;
    Mas, esse plugin apenas importa o css para o js. É necessário mais um plugin para exportar esse css para a página que é style-loader;
    O css loader manda o css pra dentro do bundle e o style loader manda isso pra uma tag style no navegador;
    Foi colocado um novo plugin pra na hora de buildar o projeto ele cria um arquivo css que vai ser carregado antes, o que evita FOUC;

## Coisas que vão ser útil mais tarde:
    o módulo **require('path');** do node devolve o caminho *absoluto* desde da instalação do OS;
    O **path** do **output** do **module.exports** no webpack.config.js, tem que absoluto;
    **--save-dev** quer em um npm intstall quer dizer que é uma biblioteca de desenvolvimento;
    **--save** quer dizer que essa biblioteca deve ser empacotada no build da aplicação, quer dizer que ela vai pro navegador ser interpretada;
    '...' essa linha no webpack quer dizer que ele vai considerar as otimizações que foram implementadas, porém não vai deixar de aplicar as defaults. Exemplo: minimizer do css;

    **$npm i -D webpack-cli @webpack-cli/serve** eu não sei o que isso faz, mas foi o que deu certo quando tava dando erro na hora de buildar o projeto com webpack dev server;
