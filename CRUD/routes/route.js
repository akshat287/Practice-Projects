const express=require("express");
const Product=require('../models/product.js');
const router=express.Router();
const {getProducts,getProduct,createProd,updateProd,deleteProd}=require('../controller/controller.js');

router.get('/',getProducts);
router.get('/:id',getProduct);

router.post('/',createProd);

router.put('/:id',updateProd);

router.delete('/:id',deleteProd);

module.exports=router;