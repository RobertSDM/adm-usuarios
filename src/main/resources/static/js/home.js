import * as main from "./main.js"

const secContentInfo = document.querySelector(".secondary-content__info")
const btn_add_tel = document.querySelector(".up__contatos__info > .telefone > .btn__add")
const btn_add_site = document.querySelector(".up__contatos__info > .site > .btn__add")
const btn_excluir_empresa = document.querySelector(".info__view__footer__button")

btn_excluir_empresa.addEventListener("click", async () => {
    const decisao = confirm("Quer mesmo excluir essa empresa?")
    if(decisao){
        await fetch(`/adm/empresa/deletar/${secContentInfo.getAttribute("data-id")}`).then(() => window.location.reload())
    }
})

btn_add_tel.addEventListener("click", async () => {
    const telefone = prompt("Qual o novo telefone")
    await fetch(`empresa/update/tel/${secContentInfo.getAttribute("data-id")}`, {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json"  // Define que o conteúdo será JSON
        },
        body: JSON.stringify({ telefone })
    }).then(() => window.location.reload())
})

btn_add_site.addEventListener("click", async () => {
    const site = prompt("Qual o novo site")
    await fetch(`empresa/update/site/${secContentInfo.getAttribute("data-id")}`, {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json"  // Define que o conteúdo será JSON
        },
        body: JSON.stringify({ site })
    }).then(() => window.location.reload())
})
