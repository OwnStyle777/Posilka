import React, { useState } from 'react';
import { View, StyleSheet, ScrollView, KeyboardAvoidingView, Platform } from 'react-native';
import { Portal, Modal, TextInput, Button, Title } from 'react-native-paper';
import { Difficulty, MuscleGroup } from '../types/Arrays';
import Dropdown from './Dropdown';
import { Exercise } from '../types/Exercise';



type ExerciseFormProps = {
    visible: boolean;
    onDismiss: () => void;
    onSubmit: (data: {
        name: string;
        muscleGroup: string;
        muscles: string;
        difficulty: string;
        instructions: string;
    }) => void;
};



export default function ExerciseForm({ visible, onDismiss, onSubmit }: ExerciseFormProps) {
    const [form, setForm] = useState({
        name: '',
        muscleGroup: '',
        muscles: '',
        difficulty: '',
        instructions: '',
    });
    const muscleGroupList = MuscleGroup;
    const difficultyList = Difficulty;

    const handleChange = (key: keyof typeof form, value: string | null) => {
        setForm(prev => ({ ...prev, [key]: value || '' }));
    };

    const handleSave = () => {
        onSubmit(form);
        setForm({ name: '', muscleGroup: '', muscles: '', difficulty: '', instructions: '' });
        onDismiss();
    };

    return (
   
        <Portal>
            <Modal visible={visible} onDismiss={onDismiss} contentContainerStyle={styles.modal}>
            <KeyboardAvoidingView
     behavior={Platform.OS === 'ios' ? 'padding' : undefined}
     keyboardVerticalOffset={60}
  >
                <Title style={styles.title}>Add New Exercise</Title>
                <ScrollView>
                    <TextInput
                        label="Name"
                        value={form.name}
                        onChangeText={v => handleChange('name', v)}
                        style={styles.input}
                    />
                    <Dropdown
                        data={muscleGroupList}
                        value={form.muscleGroup}
                        onSelect={v => handleChange('muscleGroup', v)}
                        label="Select Muscle Group"
                        headerTitle="Muscle group"
                    />

                    <TextInput
                        label="Muscles (comma separated)"
                        value={form.muscles}
                        onChangeText={v => handleChange('muscles', v)}
                        style={styles.input}
                    />
                    <Dropdown
                        data={difficultyList}
                        value={form.difficulty}
                        onSelect={v => handleChange('difficulty', v)}
                        label="Select difficulty"
                        headerTitle="Difficulty"
                    />
                    <TextInput
                        label="Instructions"
                        value={form.instructions}
                        onChangeText={v => handleChange('instructions', v)}
                        multiline
                        numberOfLines={4}
                        style={[styles.input, styles.textArea]}
                    />
                </ScrollView>
                <View style={styles.buttonRow}>
                    <Button mode="text" onPress={onDismiss}>Cancel</Button>
                    <Button mode="contained" style={styles.button} onPress={handleSave}>Save</Button>
                </View>
                </KeyboardAvoidingView>
            </Modal>
        </Portal>
    );
}


const styles = StyleSheet.create({
    button: {
        elevation: 5,
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.3,
        shadowRadius: 4,
    },
    dropdown: {
        backgroundColor: '#fff'
    },
    modal: {
        margin: 20,
        padding: 20,
        backgroundColor: 'white',
        borderRadius: 12,
    },
    title: {
        textAlign: 'center',
        marginBottom: 10,
    },
    input: {
        marginBottom: 12,
        backgroundColor: 'white',
    },
    textArea: {
        height: 100,
    },
    buttonRow: {
        flexDirection: 'row',
        justifyContent: 'flex-end',
        marginTop: 10,
    },
});
