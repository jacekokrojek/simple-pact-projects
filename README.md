# Przykład integrcji Pact.io z prostą aplikacją Java i procesem budowania opartym na GITHUB workflow
## O aplikacji
Do budowy aplikacji wykorzystano
* Maven
* JUnit4
## Integracja z GitHub Workflow i Pact broker
Pełna integracja z broker kontraktów wymaga dodania webhooka Pack Broker, poniżej przykład danych jakie należy wysłać metodą POST na adres http://<pact-broker>/webhooks
```
{
    "events": [
        {
            "name": "contract_content_changed"
        }
    ],
    "request": {
        "method": "POST",
        "url": "https://api.github.com/repos/jacekokrojek/simple-pact-projects/dispatches",
        "headers": {
            "Authorization": "token ********",
            "Accept": "application/vnd.github.everest-preview+json"
        },
        "body": {
            "event_type": "Weryfikuje build providera dla consumera",
            "client_payload": {
                "thisPactWasPublished": "${pactbroker.pactUrl}"
            }
        }
    }
}
```
