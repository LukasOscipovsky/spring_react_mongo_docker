import { AppBar, RaisedButton, TextField } from 'material-ui';
import * as React from 'react';
import axios from 'axios';

class LoginPage extends React.Component<any, any> {
    private signIn: VoidFunction;
    private data: string;

    constructor(props: any) {
        super(props);
        this.data = ''
        this.signIn = () => this.handleClickSignIn()
    }

    public render() {
        return (
            <div className="form">
                <AppBar title="Login" />
                <TextField
                    hintText="Enter your username"
                    type="text"
                    floatingLabelText="Username"
                />
                <TextField
                    hintText="Enter your password"
                    floatingLabelText="Password"
                />
                <RaisedButton
                    onClick={this.signIn}
                    label="Sign In"
                />
            </div>
        );
    }

    private async handleClickSignIn() {
        let isOk = 0
        
        const body = {
            password: 'test',
            username: 'lukas'
        }

        const axiosConfig = {
            headers: {
            'Content-Type': 'application/json'
            }
        }

        axios.post('http://127.0.0.1:8080/login', body, axiosConfig)
        .then(response => this.data = response.data)

        const axiosConfigTest = {
            headers: {
                'Authorization': this.data
            }
        }

        console.log(this.data);

        axios.get('http://127.0.0.1:8080/test', axiosConfigTest)
        .then(response => isOk = response.status)

        if (isOk === 200) {
            alert('Logged successfully');
        } else {
            alert('Not successfull')
        }
    }
}

export default LoginPage;