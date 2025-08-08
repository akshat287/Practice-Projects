const mongoose=require('mongoose');

const InformationSchema=mongoose.Schema(
    {
        Name:{
            type:String,
            required: [true,"Enter Full Name"]
        },

        Enrollment:{
            type:String,
            required:[true,"Enter Enrollment"]
        },

        Contact:{
            type:Number,
            required:[true]
        },

        Email_Id:{
            type:String,
            required:true
        },

        DOB:{
            type:String,
            required:true
        },

        Department:{
            type:String,
            required:false
        },
    },
    {
        timestamps:true,
    }
);

const Student=mongoose.model("Student",InformationSchema);
module.exports=Student;