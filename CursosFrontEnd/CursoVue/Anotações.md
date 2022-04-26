#Curso vue

    Instalações vue
        $npm install vue
        $npm install vue-cli

    Criando projeto vue
        $vue init webpack-simple farolpic
                  (template)     (nome do projeto)

    Comandos vue
        $npm install vue-resource@
        $npm install vue-router@ --save
    
    ## Anotações 
        -g <- instala uma depêndencia node globalmente na máquina
        pra usar os valores do data no html, se usa o {{}}, mas para setar valores de atributos se usa o v-bind. Ex v-bind:src"atributo do data"
        : <- é uma abreviação do v-bind:
        @ <- é uma abrviação do v-on:


    ## Erros solucionados
        1. O arquivo C:\Users\DEV-02\AppData\Roaming\npm\vue.ps1 não pode ser carregado porque a execução de scripts foi desabilitada neste sistema.
        Solução:
            Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
        2.