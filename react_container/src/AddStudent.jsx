import React from "react"
import { useState } from "react"
import axios from "axios"
import { useNavigate } from "react-router-dom"
import { TextField, Button, Box, Typography } from "@mui/material";

function Addetudiant(){
    const navigate=useNavigate()
    const [nom,setNom]=useState("")
    async function createStudent() {
        const objectStudent={nom:nom}
        axios.post(`http://back.com/Students`,objectStudent)
        navigate('/')
        
    }
    function handleChange(e){
              setNom(e.target.value)
    }
    return(
<Box
        sx={{
          maxWidth: 400,
          mx: "auto",
          mt: 5,
          p: 3,
          boxShadow: 3,
          borderRadius: 2,
          backgroundColor: "white",
        }}
      >
        <Typography variant="h5" component="h2" gutterBottom align="center">
          Ajouter Etudiant
        </Typography>
          {/* Champ Nom */}
          <TextField
            label="Nom"
            name="name"
            onChange={handleChange}
            fullWidth
            margin="normal"
            variant="outlined"
            ></TextField>
          
  
          
  
          
            <Button 
            type="submit"
            variant="contained"
            color="primary"
            fullWidth
            sx={{ mt: 2 }}
            onClick={()=>{
                createStudent()
            }}
          >
            Soumettre
          </Button>
      </Box>    )
}
export default Addetudiant