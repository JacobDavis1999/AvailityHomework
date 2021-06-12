import React from 'react'
import {FaTimes} from "react-icons/fa"

const Client = ({client, deleteClient}) => {

 
//Deepest level component, displays existing client info from db on page      
//Includes custom delete button that removes that respective client from db and page    
return(
    <div className ="client">
    <div>
        <h3 key={client.id}>{client.firstName} {client.lastName}; </h3> 
        <p>{client.NPINumber}; {client.businessAddress}; {client.phoneNumber}; {client.email}</p>
    </div>
    <div>
        
        <button onClick={() =>deleteClient(client.id)}>
            <FaTimes style={{ color: "red"}}/>
        </button>
    </div>
    </div>

 )
                  
            
      
  }

  export default Client