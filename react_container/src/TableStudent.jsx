import React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import axios from "axios";
import { useEffect,useState } from "react";
import { useNavigate } from "react-router-dom";
function Studentss(){
    const [students,setStudents]=useState([])
    const navigate=useNavigate();
    function switching(student){
         navigate('/Details',{state:student})
    }

    const dataofstudents=async function  () {
            const getstudents=await axios.get('http://back.com/Students?sort=sort')
        console.log(getstudents.data)
        setStudents(getstudents.data)  
            
    

    }
    const deletetudent=async function(id) {
        await axios.delete(`http://back.com/Students/${id}`)
        navigate('/')

        
    }
    useEffect(()=>{
        dataofstudents();
        console.log(students)
    },[]) 
    return(
        <>
        
        <TableContainer component={Paper}>
           <Table>
            <TableHead>
                <TableRow>
                    <TableCell> Name</TableCell>
                    <TableCell> Moyenne</TableCell>
                    <TableCell> Details d'etudiant</TableCell>
                    <TableCell> Supprimer etudiant</TableCell>



                </TableRow>
            </TableHead>
            <TableBody>
            {students.map((element) => (
                <TableRow
                key={element.id_student}
                style={{ backgroundColor: element.moyen < 10 ? "#ffcccc" : "transparent" }} // Rouge clair si la moyenne < 10
                 >
                  <TableCell>{element.nom}</TableCell>
                  <TableCell>{element.moyen}</TableCell>
                  <TableCell>{<button onClick={()=>{switching(element)}}>Details</button>}</TableCell>
                  <TableCell>{<button onClick={()=>{deletetudent(element.id_student)}} >Supprimer</button>}</TableCell>

                  </TableRow>
                               ))}
            </TableBody>

              </Table>
        </TableContainer>
        <p>Note:pour supprimer un etudiant il faut tout d'abord supprimer ses notes</p>
        </>

     



    )

}
export default Studentss
