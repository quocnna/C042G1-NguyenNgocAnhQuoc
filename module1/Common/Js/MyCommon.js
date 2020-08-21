const getPath = document.querySelector("script").getAttribute("src");
const script = (filename)=>{
    const h =document.querySelector("head");
    const s = document.createElement("script");
    s.src = getPath.replace("MyCommon.js",filename);
    h.append(s);
}

script("Jquery-3.5.1.js");