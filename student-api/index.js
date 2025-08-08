const express=require('express');
const mongoose=require('mongoose');
const Student=require('./models/studentmodel.js');
const app=express()

app.use(express.json);
app.use(express.urlencoded({extended:false}));


app.use('/api/students',student.route)



app.get('/',(req,res)=>{
    res.send("hello from student-api!!")
});


//Read data
app.get('/api/students',async(req,res)=>{
    try{
        const student=await Student.find({});
        res.status(200).json(prod);
    }
    catch(err){
        res.status(500).json({message:err.message});
    }
})


//Read by Id
app.get('/api/student/:id',async(req,res)=>{
    try{
        const {id}=req.params;
        const student=await Student.findById(id);
        res.status(200).json(student);
    }
    catch(err){
        res.status(500).json({message:err.message});
    }
})


//Create API
app.post('/api/students',async (req,res)=>{
   try{
      const student=await Student.create(req.body);
      res.status(200).json(student);
   } catch(err){
    res.status(500).json({message:err.message});
   }
});


//Update API
app.put('/api/student/:id',async(req,res)=>{
    try{
        const {id}=req.params;
        const student=await Student.findByIdAndUpdate(id,req.body);

        if(!student){
            return res.status(404).json({message:"Student Not Found"});
        }

        const updatestud=await Student.findById(id);
        res.status(200).json(updatestud);
    }
    catch(err){
        res.status(500).json({message:err.message});
    }
})

//Delete Student
app.delete('/api/student/:id', async(req,res)=>{
    try{
        const {id}=req.params;
        const stud=await Student.findByIdAndDelete(id);
        if(!stud){
            return res.status(404).json({message:"Student Not Found"});
        }
        res.status(200).json({message:"Student terminated!!"});
    }
    catch(err){
        res.status(500).json({message:err.message});
    }
})


mongoose.connect("mongodb+srv://StudentUser:Dgw592Hd17AjDXHL@backenddb.cuktp8u.mongodb.net/Student-API?retryWrites=true&w=majority&appName=backendDB")
.then(()=>{
    console.log("connected to database!");
    app.listen(3001,()=>{
    console.log('Server is runknig');
});
})
.catch(()=>{
    console.log("Connection failed!");
})