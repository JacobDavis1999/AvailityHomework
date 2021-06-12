import React, {useState} from 'react'

export const ClientForm = ({addClient}) => {

    //state management for first name field
    const [fnValue, setFnValue] = useState("");

    //On Click function for first name field
    const handleChangeFn = (event) =>{
     const {value}  = event.currentTarget;
     setFnValue(value);
    }

    //state management for last name field
    const [lnValue, setLnValue] = useState("");

    //On Click function for last name field
    const handleChangeLn = (event) =>{
        const {value}  = event.currentTarget;
        setLnValue(value);
       }

       //state management for npi field
       const [npiValue, setNpiValue] = useState("");

       //On Click function for npi field
       const handleChangeNpi = (event) =>{
        const {value}  = event.currentTarget;
        setNpiValue(value);
       }

       //state management for address field
       const [adValue, setAdValue] = useState("");

       //On Click function for address field
       const handleChangeAd = (event) =>{
        const {value}  = event.currentTarget;
        setAdValue(value);
       }

       //state management for phone field
       const [phoneValue, setPhoneValue] = useState("");

       //On Click function for phone field
       const handleChangePhone = (event) =>{
        const {value}  = event.currentTarget;
        setPhoneValue(value);
       }

       //state management for email field
       const [emailValue, setEmailValue] = useState("");

       //On Click function for email field
       const handleChangeEmail = (event) =>{
        const {value}  = event.currentTarget;
        setEmailValue(value);
       }

       //Custom handleSubmit to prevent page refresh and calls addClient function 
       const handleSubmit = (event) => {
           event.preventDefault();
            
            addClient(fnValue, lnValue, npiValue, adValue, phoneValue, emailValue);
       }

    
       //Form fields with their custom onChange functions
    return (
        <form onSubmit={handleSubmit}>
            <div className="form-control">

            <label htmlFor="firstName">First Name: </label>
            <input type ="text" name="firstName" id="firstName" value={fnValue} onChange={handleChangeFn}/>

            <label htmlFor="lastName">Last Name: </label>
            <input type ="text" name="lastName" id="lastName" value={lnValue} onChange={handleChangeLn} />

            <label htmlFor="npi">NPI Number: </label>
            <input type ="text" name="npi" id="npi" value={npiValue} onChange={handleChangeNpi}/>

            <label htmlFor="address">Address: </label>
            <input type ="text" name="address" id="address" value={adValue} onChange={handleChangeAd}/>

            <label htmlFor="phone">Phone: </label>
            <input type ="text" name="phone" id="phone" value={phoneValue} onChange={handleChangePhone}/>

            <label htmlFor="email">Email: </label>
            <input type ="text" name="email" id="email" value={emailValue} onChange={handleChangeEmail}/>
       </div> 
       
       <div className="form-control">
           <button type="submit">Submit</button>
       </div>
       </form>
    )
}

export default ClientForm
