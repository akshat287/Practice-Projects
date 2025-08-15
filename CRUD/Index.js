const express=require('express');
const mongoose=require('mongoose');
const Product = require('./models/product.js');
const productRoute=require('./routes/route.js');
const app=express();

//Malwares
app.use(express.json());
app.use(express.urlencoded({extended:false}));

//Routes
app.use('/api/products',productRoute);


app.get('/',(req,res)=>{
    res.send("hello from Node api server Updated");
});



// // Read API
// app.get('/api/products', async(req,res)=>{
//     try{
//         const prod=await Product.find({});
//         res.status(200).json(prod);
//     }
//     catch(err){
//         res.status(500).json({message:err.message});
//     }
// })

// // Read by Id
// app.get('/api/product/:id',async(req,res)=>{
//     try{
//         const {id}=req.params;
//         const prod=await Product.findById(id);
//         res.status(200).json(prod);
//     }
//     catch(err){
//         res.status(500).json({message: err.message});
//     }
// })


// // Create API
// app.post('/api/products', async(req,res)=>{
//    try{
//     const product=await Product.create(req.body);
//     res.status(200).json(product);
//    }
//    catch(error){
//     res.status(500).json({message: error.message});
//    }
// })

// // Update product
// app.put('/api/product/:id',async(req,res)=>{
//     try{
//         const {id}=req.params;
//         const product=await Product.findByIdAndUpdate(id,req.body);

//         if(!product){
//             return res.status(404).json({message: "Product not found"});
//         }

//         const updateProd=await Product.findById(id);
//         res.status(200).json(updateProd);
//     }
//     catch(err){
//         res.status(500).json({message: err.message});
//     }
// })


// //Delete prod
// app.delete('/api/product/:id', async(req,res)=>{
//     try{
//         const {id}=req.params;
//         const prod=await Product.findByIdAndDelete(id);
//         if(!prod){
//             return res.status(404).json({message:"Product not found"});
//         }
//         res.status(200).json({message:"Product deleted Successfully"});
//     }
//     catch(err){
//         res.status(500).json({message: err.message});
//     }
// })



mongoose.connect("mongodb+srv://tiwariakshat101:2rUefA4ELafIkyTl@backenddb.4nucebp.mongodb.net/Node-api?retryWrites=true&w=majority&appName=backendDB")
.then(()=>{
    console.log("connected to database!")
})
.catch(()=>{
    console.log("Failed to connect!!")
})

app.listen(3000,()=>{
    console.log('Server is running')
});