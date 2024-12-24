import { useState } from 'react'
import reactLogo from './assets/react.svg'
import Dashboard from'./DashBardPage'
import { BrowserRouter as Router,Routes,Route } from 'react-router-dom'
import Studentss from './TableStudent'
import DetailsStudent from './DetailsPage'
import Addnote from './AjouterNote'
import Addetudiant from './AddStudent'
function App() {
  

  return (
    <Router>
      <Routes>
        <Route path='/' element={<Dashboard></Dashboard>}></Route>
        <Route path='/Table' element={<Studentss></Studentss>}></Route>
        <Route path='/Details' element={<DetailsStudent></DetailsStudent>}></Route>
        <Route path='/Ajouter_Note' element={<Addnote></Addnote>}></Route>
        <Route path='/Ajouter_etudaint' element={<Addetudiant></Addetudiant>}></Route>
      </Routes>
    </Router>
  )
}

export default App
