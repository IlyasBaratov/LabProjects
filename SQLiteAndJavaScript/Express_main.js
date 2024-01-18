let hotels;

const {json} = require('body-parser');
const express = require ('express');
const sqlite = require('sqlite3').verbose();
const app = express();
app.use(express.json());
const db = new sqlite.Database("C:\\Users\\user\\Desktop\\Javascript\\Expres_learn\\final_versionfinal_sequal.db",sqlite.OPEN_READWRITE,(err)=>{
    if (err) return console.error(err.message);
});
db.all;
let sql = 'SELECT hotel_name FROM hotel';   
db.all(sql,[],(err,rows)=>{
    if (err) return console.error(err.message);
    else{
    hotels = rows.map(row=>row.hotel_name);
    rows.forEach(row=>{
        console.log(row);
    })
}
});


// app.get("/",(req,res)=>{
    //     console.log("here");
    //     // res.send("HIHIHI")
    //     // res.download("C:\\Users\\user\\Desktop\\Javascript\\Expres_learn\\Express_main.js");
    // })
    app.get("/",(req,res)=>{
        res.json(hotels);
    });
    app.get ("/installing",(req, res)=>{
        res.download("C:\\Users\\user\\Desktop\\Javascript\\Expres_learn\\Express_main.js");
    })
    
   
    app.post("/posting",(req,res) =>{
        console.log(req.body);
        let new_hotel = JSON.parse(JSON.stringify(req.body));
        hotels.push(new_hotel.hotel_name);
        res.json(hotels);
    });
app.listen(3000);