import React from "react";
import "./style.css";
import axios from'axios'
import { useNavigate } from "react-router-dom";

function dashboard(){
  const navigate=useNavigate();
  function saute1(){
        navigate('/Table')
  }
  function saute2(){
    navigate('/Ajouter_etudaint')
  }
   

    return(
        
            <div>
             
              
        
              <section className="hero">
                <div className="content">
                  <h1>
                    Organize your <span>Students</span>.
                  </h1>
                  <p>Tap into nature with 100% clean electricity.</p>
                  <div className="buttons">
                    <button className="primary" onClick={()=>{saute2()}}>Add Student</button>
                    <button className="secondary" onClick={()=>{
                      saute1()
                    }}> Get all Student</button>
                    
                  </div>
                </div>
                
              </section>
            </div>
          




    )
}
export default dashboard