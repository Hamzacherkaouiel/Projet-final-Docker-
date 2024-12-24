import React from "react"
import { useState } from "react"
import { TextField, Button, Box, Typography } from "@mui/material";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";

function Addnote(){
    const [nom,setNom]=useState("")
    const [value,setValue]=useState(0)
    const location=useLocation();
    const navigate=useNavigate();
    const id=location.state
    async function CreateNote() {
        const note={nom:nom,value:value}
        await axios.post(`http://back.com/Students/${id}/Notes`,note)
        
    }
    const handleChangeName=(e)=>{
         setNom(e.target.value)
    }
    const handleChangeValue=(e)=>{
        const number=Number(e.target.value)
        setValue(number)

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
          Ajouter Note
        </Typography>
          {/* Champ Nom */}
          <TextField
            label="Matiere"
            name="name"
            onChange={handleChangeName}
            fullWidth
            margin="normal"
            variant="outlined"
            ></TextField>
          
  
          {/* Champ Email */}
          <TextField
            label="Note"
            name="email"
            fullWidth
            margin="normal"
            variant="outlined"
            onChange={handleChangeValue}
          />
  
          
  
          {/* Bouton Soumettre */}
          <Button 
            type="submit"
            variant="contained"
            color="primary"
            fullWidth
            sx={{ mt: 2 }}
            onClick={()=>{
                CreateNote()
            }}
          >
            Soumettre
          </Button>
      </Box>
    )

}
export default Addnote