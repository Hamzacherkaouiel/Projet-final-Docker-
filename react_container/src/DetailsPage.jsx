import React from "react"
import { useState, useEffect } from "react"
import { useLocation ,useNavigate} from "react-router-dom"
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import axios from "axios";
import "./style.css";


function DetailsStudent(){
    const [Notes,setNotes]=useState([])
    const Navigate=useNavigate();
    const location=useLocation();
    const dataReciver=location.state;
    async function  getNote(id){
         const note=await axios.get(`http://back.com/Students/${id}/Notes?sort=sort`)
         console.log(note.data)
         setNotes(note.data)
    }
    function switching(){
       Navigate('/Ajouter_Note',{state:dataReciver.id_student})
    }
    useEffect(()=>{
        getNote(dataReciver.id_student)
        console.log(Notes)
    },[])
    async function suppression(id){
        axios.delete(`http://back.com/Students/${dataReciver.id_student}/Notes/${id}`)
        Navigate('/Table')
    }



   return(
    <div className="display">
        <div className="navv">
        <p className="etudiant">Nom Etudaint  :{dataReciver.nom} </p>
        <button className="b" onClick={()=>{switching()}}> Ajouter Note</button>

        </div>
        <TableContainer component={Paper}>
         <Table>
            <TableHead>
                <TableRow>
                    <TableCell>Nom de Matiere</TableCell>
                    <TableCell>Note</TableCell>
                    <TableCell>Supprimer Note</TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
                {Notes.map((element)=>(
                    <TableRow key={element.id_note} style={{ backgroundColor: element.value < 10 ? "#ffcccc" : "transparent" }}>
         
                    <TableCell>{element.nom}</TableCell>
                    <TableCell>{element.value}</TableCell>
                    <TableCell>{<button onClick={()=>{
                        suppression(element.id_note)
                    }}>Supprimer</button>}</TableCell>




                    </TableRow>
                    
                ))}
            </TableBody>
            
         </Table>
        </TableContainer>

    </div>
   )
}
export default DetailsStudent