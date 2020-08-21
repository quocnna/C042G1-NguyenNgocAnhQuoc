globalThis.customElements.define("custom-element",class extends HTMLElement{
    constructor() {
        super();
        const shadow = this.attachShadow({mode:"open"});

        const divContainer = document.createElement("div");
        divContainer.setAttribute("id","container");

        const divDisplay = document.createElement("div");
        divDisplay.classList.add("secDisplay");
        const input = document.createElement("input");
        input.setAttribute("id","ipNumber");
        input.setAttribute("type","number");
        const label = document.createElement("label")
        label.textContent= this.getAttribute("lb-text");

        const divButton = document.createElement("div");
        divButton.classList.add("secButton")
        const btAdd = document.createElement("button");
        btAdd.setAttribute("id","btAdd");
        btAdd.textContent="Add";
        const btSort = document.createElement("button");
        btSort.setAttribute("id","btSort");
        btSort.textContent=this.getAttribute("bt-text");

        const linkElem = document.createElement('link');
        linkElem.setAttribute('rel', 'stylesheet');
        linkElem.setAttribute('href', 'MyStyle.css');

        shadow.appendChild(linkElem);
        shadow.appendChild(divContainer);
        divContainer.appendChild(divDisplay);
        divContainer.appendChild(divButton);
        divDisplay.appendChild(input);
        divDisplay.appendChild(label);
        divButton.appendChild(btAdd);
        divButton.appendChild(btSort);

        shadow.addEventListener("click",e=>{
            let ele = e.target;
            if(ele.textContent=="Add"){
                  const test = this.getAttribute("test");
                  eval(test);
            }
            else if(ele.textContent==this.getAttribute("bt-Text")) {
                alert(this.tagName);
            }
        });
    }
});