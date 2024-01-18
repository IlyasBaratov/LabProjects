const btn = document.querySelector(".Button");
const btn2 = document.querySelector(".onclick_button");
var user_input;
function response (){
    const cofirming = window.confirm("Do you really want to do it? ");
    if (cofirming == true){
    const attribute = document.createAttribute('class');
    const element = document.createElement("h2");
    fetch_data('http://localhost:3000',element,attribute,'hotell');
    }
}
let counting = 1;
async function fetch_data(address,element, attribute,type){
    // counting+=1;
    const raw_result = await fetch(address);
    const result = await raw_result.json( );
    result.forEach(row => {
        const text = document.createTextNode("\""+row + "\"    city is the element number  \""+(counting++)+"\"");
        element.appendChild(text);
        document.body.appendChild(element);
        element.appendChild(document.createElement("br"));
    });
    element.setAttributeNode(attribute);
    attribute.value = (type);
}
// async function for_posting () {
//     await save_data();
//     let jason_string = await {"hotel_name" : user_input};
//     console.log(user_input);
//     const raw_result_posting = await fetch("http://localhost:3000/posting",{
//         method: "POST",
//         headers:{
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(jason_string)
//     });
// }

// async function save_data(){
//     user_input = document.getElementById("user_input").value;
//     console.log(user_input);
//     return user_input;
// }

// btn2.addEventListener('click', for_posting);

btn.addEventListener('click', response);
