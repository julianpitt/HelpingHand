<!DOCTYPE html>
<html>
<head>
    <title>{{ $title or "Helping Hand" }}</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="pragma" content="no-cache"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    @include('common.styles')
</head>
<body class="page-{{ $page or "" }}">