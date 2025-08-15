const express=require("express");
const Product = require("../models/product");

const getProducts=async(req,res)=>{
    try{
        const products=await Product.find({});
        res.status(200).json(products);
    }
    catch(err){
        res.status(500).json({message:err.message});
    }
};

const getProduct=async(req,res)=>{
    try{
        const {id}=req.params;
        const prod=await Product.findById(id);
        res.status(200).json(prod);
    }
    catch(err){
        res.status(500).json({message:err.message});
    }
};

const createProd=async(req,res)=>{
    try{
        const prod=await Product.create(req.body);
        res.status(200).json(prod);
    }
    catch(err){
        res.status(500).json({message:err.message});
    }
};

const updateProd=async(req,res)=>{
    try{
        const {id}=req.params;
        const prod=await Product.findByIdAndUpdate(id,req.body);
        if(!prod){
            return res.status(404).json({message:"Product not founded!!"});
        }
        const update=await Product.findById(id);
        res.status(200).json(update);
    }
    catch(err){
        res.status(500).json({message:err.message});
    }
};

const deleteProd=async(req,res)=>{
    try{
        const {id}=req.params;
        const prod=await Product.findByIdAndDelete(id);
        if(!prod){
            return res.status(404).json({message:"Product not founded!!"});
        }
        res.status(200).json(prod);
    }
    catch(err){
        res.status(500).json({message:err.message});
    }
};


module.exports={
    getProducts,
    getProduct,
    createProd,
    updateProd,
    deleteProd
};